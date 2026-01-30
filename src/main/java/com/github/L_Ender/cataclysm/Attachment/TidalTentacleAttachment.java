package com.github.L_Ender.cataclysm.Attachment;

import java.util.UUID;

public class TidalTentacleAttachment {

	private UUID lastTentacle;
	private boolean tentacle;
	public int id;

	public void setHasTentacle(boolean Tentacle) {
		this.tentacle = Tentacle;
	}

	public boolean hasTentacle() {
		return this.tentacle;
	}

	public void setLastTentacleID(int frozenPitch) {
		this.id = frozenPitch;
	}

	public int getLastTentacleID() {
		return id;
	}

	public void setLastTentacleUUID(UUID livingEntity) {
		lastTentacle = livingEntity;
	}

	public UUID getLastTentacleUUID() {
		return lastTentacle;
	}
}
