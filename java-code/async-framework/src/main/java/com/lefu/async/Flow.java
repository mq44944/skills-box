package com.lefu.async;

/**
 * 流程基础定义
 * @author jiang.li
 *
 */
public interface Flow extends Destroy {
	/**
	 * 获取流程ID
	 * @return
	 */
	public long getId();
	/**
	 * 获取流程上下文
	 * @return
	 */
	public FlowContext getContext();
	/**
	 * 获取队列容器
	 * @return
	 */
	public QueueContainer getQueueContainer();
	/**
	 * 获取指定队列的当前流程内的事件处理状态
	 * <pre>
	 * 当流程初始化时，所有队列对应此流程的事件状态都是 {@link EventStatus#UNKOWN}
	 * 当对应队列的事件开始时，状态为 {@link EventStatus#STARTED}
	 * 当对应队列的事件正常处理结束，状态为 {@link EventStatus#FINISHED}
	 * 当对应队列的事件处理异常，状态为 {@link EventStatus#EXCEPTION}
	 * </pre>
	 * @param queueName
	 * @return
	 * @throws QueueNotFoundException 尝试获取不存在的/不记录状态的队列事件处理状态时会抛出异常
	 */
	public EventStatus getQueueEventStatus(String queueName) throws QueueNotFoundException;
	/**
	 * 更新事件处理状态
	 * <pre>不要调用这个方法，状态设置是框架内部使用的</pre>
	 * @param queueName
	 * @param status
	 * @throws QueueNotFoundException
	 */
	public void putQueueEventStatus(String queueName, EventStatus status) throws QueueNotFoundException;
}
