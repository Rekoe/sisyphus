package com.github.houbb.sisyphus.core.support.condition;

import com.github.houbb.heaven.annotation.ThreadSafe;
import com.github.houbb.heaven.util.lang.ObjectUtil;
import com.github.houbb.sisyphus.api.model.RetryAttempt;
import com.github.houbb.sisyphus.api.support.condition.RetryCondition;

/**
 * 根据结果进行重试的抽象类
 * @author binbin.hou
 * @since 0.0.1
 */
@ThreadSafe
public abstract class AbstractCauseRetryCondition implements RetryCondition {

    @Override
    public boolean condition(RetryAttempt retryAttempt) {
        return causeCondition(retryAttempt.cause());
    }

    /**
     * 对异常信息进行判断
     * 1. 用户可以判定是否有异常
     * @param throwable 异常信息
     * @return 对异常信息进行判断
     */
    protected abstract boolean causeCondition(final Throwable throwable);

    /**
     * 判断是否有异常信息
     * 1. 有，返回 true
     * 2. 无，返回 false
     * @param throwable 异常信息
     * @return 是否有异常信息
     */
    protected boolean hasException(final Throwable throwable) {
        return ObjectUtil.isNotNull(throwable);
    }

}
