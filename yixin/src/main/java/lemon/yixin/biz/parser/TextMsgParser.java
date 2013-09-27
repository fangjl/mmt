package lemon.yixin.biz.parser;

import org.springframework.stereotype.Service;

import lemon.shared.api.Message;
import lemon.yixin.bean.message.MsgType;
import lemon.yixin.bean.message.TextMessage;

/**
 * A text message parser
 * 
 * @author lemon
 * @version 1.0
 * 
 */
@Service(YXMsgParser.PREFIX + MsgType.TEXT)
public final class TextMsgParser extends YXMsgParser {

	@Override
	public final TextMessage toMsg(String msg) {
		xStream.processAnnotations(TextMessage.class);
		return (TextMessage) xStream.fromXML(msg);
	}

	@Override
	public final String toXML(Message rMsg) {
		xStream.processAnnotations(TextMessage.class);
		return xStream.toXML(rMsg);
	}
}
