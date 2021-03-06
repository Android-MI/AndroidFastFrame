package com.fast.frame.interrface;

/**
 * 说明：IFrameRegister
 * @author xiaomi
 */
public interface IFrameRegister {
    /**
     * 是否注册EventBus
     * @return
     */
    boolean isRegisterEventBus();

    /**
     * 是否绑定ButterKnife
     * @return
     */
    boolean isBindButterKnife();
}
