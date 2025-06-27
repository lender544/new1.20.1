package com.github.L_Ender.cataclysm.entity.etc;

public interface IShieldEntity {

    int getShieldCooldownTime();

    void setShieldCooldownTime(int shieldCooldownTime);

    void disableShield(boolean guaranteeDisable);

    boolean isShieldDisabled();

}
