package com.github.L_Ender.cataclysm.util.AssetsProtector;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.CompletableFuture;

import javax.imageio.ImageIO;

import com.mojang.blaze3d.platform.NativeImage;
import com.mojang.blaze3d.platform.TextureUtil;
import com.mojang.blaze3d.systems.RenderSystem;

import net.minecraft.Util;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.SimpleTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.Resource;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class AESTexture extends SimpleTexture 
{
	public final File cacheFile;

	private CompletableFuture<?> future;

	private boolean textureUploaded;

	public AESTexture(File file, ResourceLocation resource) 
	{
		super(resource);
		this.cacheFile = file;
	}

	public void loadCallback(NativeImage image) 
	{
		Minecraft.getInstance().execute(() ->
		{
			this.textureUploaded = true;
			if(!RenderSystem.isOnRenderThread()) 
			{
				RenderSystem.recordRenderCall(() -> 
				{
					this.upload(image);
				});
			}
			else
			{
				this.upload(image);
			}
		});
	}

	private void upload(NativeImage p_118021_) 
	{
		TextureUtil.prepareImage(this.getId(), p_118021_.getWidth(), p_118021_.getHeight());
		p_118021_.upload(0, 0, 0, true);
	}

	@Override
	public void load(ResourceManager resourceManager) throws IOException 
	{
		Minecraft.getInstance().execute(() ->
		{
			if(!this.textureUploaded)
			{
				synchronized(this)
				{
					this.textureUploaded = true;
				}
			}
		});
		if(this.future == null)
		{
			if(this.cacheFile != null && this.cacheFile.isFile())
			{
				NativeImage image = null;
				try
				{
					image = NativeImage.read(new FileInputStream(this.cacheFile));
					this.loadCallback(this.process(image));
				} 
				catch (IOException ioexception) 
				{
					this.loadTexture();
				}
			} 
			else 
			{
				this.loadTexture();
			}
		}
	}

	protected void loadTexture() 
	{
		this.future = CompletableFuture.runAsync(() ->
		{
			try 
			{
		        Resource resource = Minecraft.getInstance().getResourceManager().getResourceOrThrow(this.location);
		        InputStream inputStream = ImageIO.read(resource.open()) != null ? resource.open() : AESUtil.decrypt(resource.open().readAllBytes());
				try
				{
					NativeImage nativeimage = this.process(NativeImage.read(inputStream));
					Minecraft.getInstance().execute(() ->
					{
						if(nativeimage != null)
						{
							this.loadCallback(nativeimage);
						}
					});
				}
				catch(IOException iOException) 
				{
					iOException.printStackTrace();
				}
				return;
			}
			catch(Exception exception)
			{
				exception.printStackTrace();
			}
		}, Util.backgroundExecutor());
	}

	public NativeImage process(NativeImage image)
	{
		int scale = image.getWidth() / 64;
		boolean lvt_2_1_ = (image.getHeight() != image.getWidth());
		if(lvt_2_1_)
		{
			try(NativeImage nativeImage = new NativeImage(64 * scale, 64 * scale, true))
			{
				nativeImage.copyFrom(image);
				image.close();
				image = nativeImage;
				nativeImage.fillRect(0, 32 * scale, 64 * scale, 32 * scale, 0);
				nativeImage.copyRect(4 * scale, 16 * scale, 16 * scale, 32 * scale, 4 * scale, 4 * scale, true, false);
				nativeImage.copyRect(8 * scale, 16 * scale, 16 * scale, 32 * scale, 4 * scale, 4 * scale, true, false);
				nativeImage.copyRect(0, 20 * scale, 24 * scale, 32 * scale, 4 * scale, 12 * scale, true, false);
				nativeImage.copyRect(4 * scale, 20 * scale, 16 * scale, 32 * scale, 4 * scale, 12 * scale, true, false);
				nativeImage.copyRect(8 * scale, 20 * scale, 8 * scale, 32 * scale, 4 * scale, 12 * scale, true, false);
				nativeImage.copyRect(12 * scale, 20 * scale, 16 * scale, 32 * scale, 4 * scale, 12 * scale, true, false);
				nativeImage.copyRect(44 * scale, 16 * scale, -8 * scale, 32 * scale, 4 * scale, 4 * scale, true, false);
				nativeImage.copyRect(48 * scale, 16 * scale, -8 * scale, 32 * scale, 4 * scale, 4 * scale, true, false);
				nativeImage.copyRect(40 * scale, 20 * scale, 0, 32 * scale, 4 * scale, 12 * scale, true, false);
				nativeImage.copyRect(44 * scale, 20 * scale, -8 * scale, 32 * scale, 4 * scale, 12 * scale, true, false);
				nativeImage.copyRect(48 * scale, 20 * scale, -16 * scale, 32 * scale, 4 * scale, 12 * scale, true, false);
				nativeImage.copyRect(52 * scale, 20 * scale, -8 * scale, 32 * scale, 4 * scale, 12 * scale, true, false);
			}
		}
		if(lvt_2_1_)
		{
			setAreaTransparent(image, 32 * scale, 0, 64 * scale, 32 * scale);
		}
		return image;
	}

	private static void setAreaTransparent(NativeImage image, int x, int y, int width, int height) 
	{
		for(int i = x; i < width; i++)
		{
			for(int j = y; j < height; j++)
			{
				int k = image.getPixelRGBA(i, j);
				if((k >> 24 & 0xFF) < 128)
					return;
			}
		}
		for(int l = x; l < width; l++)
		{
			for(int i1 = y; i1 < height; i1++)
			{
				image.setPixelRGBA(l, i1, image.getPixelRGBA(l, i1) & 0xFFFFFF);
			}
		}
	}
}
