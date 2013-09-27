package lemon.weixin.biz.parser;

import org.springframework.stereotype.Service;

import lemon.shared.api.Message;
import lemon.weixin.bean.message.EventMessage;
import lemon.weixin.bean.message.MsgType;

/**
 * An event message parser
 * 
 * @author lemon
 * @version 1.0
 * 
 */
@Service(WXMsgParser.PREFIX + MsgType.EVENT)
public final class EventMsgParser extends WXMsgParser {

	@Override
	public final EventMessage toMsg(String msg) {
		xStream.processAnnotations(EventMessage.class);
		return (EventMessage) xStream.fromXML(msg);
	}

	@Override
	public final String toXML(Message rMsg) {
		xStream.processAnnotations(EventMessage.class);
		return xStream.toXML(rMsg);
	}
}
