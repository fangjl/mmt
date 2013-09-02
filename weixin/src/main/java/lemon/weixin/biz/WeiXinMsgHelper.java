package lemon.weixin.biz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lemon.weixin.bean.message.*;
import lemon.weixin.dao.WXRecvMsgDetailMapper;
import lemon.weixin.dao.WXSendMsgDetailMapper;

/**
 * WeiXin message helper
 * @author lemon
 *
 */
@Service
public final class WeiXinMsgHelper {
	//FIXME fix encoding problem
	@Autowired
	private WXRecvMsgDetailMapper recvMsgMapper;
	@Autowired
	private WXSendMsgDetailMapper sendMsgMapper;
	
	/**
	 * save received WeiXin event message
	 * @param msg
	 */
	public void saveRecvEventMsg(EventMessage msg){
		saveRecvMsg(msg);
		recvMsgMapper.saveEventMsgDetail(msg);
	}
	
	/**
	 * save received WeiXin image message
	 * @param msg
	 */
	public void saveRecvImageMsg(ImageMessage msg){
		saveRecvMsg(msg);
		recvMsgMapper.saveImageMsgDetail(msg);
	}
	
	/**
	 * save received WeiXin link message
	 * @param msg
	 */
	public void saveRecvLinkMsg(LinkMessage msg){
		saveRecvMsg(msg);
		recvMsgMapper.saveLinkMsgDetail(msg);
	}
	
	/**
	 * save received WeiXin location message
	 * @param msg
	 */
	public void saveRecvLocationMsg(LocationMessage msg){
		saveRecvMsg(msg);
		recvMsgMapper.saveLocationMsgDetail(msg);
	}
	
	/**
	 * save received WeiXin text message
	 * @param msg
	 */
	public void saveRecvTextMsg(TextMessage msg){
		saveRecvMsg(msg);
		recvMsgMapper.saveTextMsgDetail(msg);
	}
	
	/**
	 * save received WeiXin video message
	 * @param msg
	 */
	public void saveRecvVideoMsg(VideoMessage msg){
		saveRecvMsg(msg);
		recvMsgMapper.saveVideoMessageDetail(msg);
	}
	
	/**
	 * save received WeiXin voice message
	 * @param msg
	 */
	public void saveRecvVoiceMsg(VoiceMessage msg){
		saveRecvMsg(msg);
		recvMsgMapper.saveVoiceMsgDetail(msg);
	}
	
	/**
	 * save send WeiXin music message
	 * @param msg
	 */
	public void saveSendMusicMsg(MusicMessage msg){
		saveSendMsg(msg);
		sendMsgMapper.saveMusicMsgDetail(msg);
	}
	
	/**
	 * save send WeiXin music message
	 * @param msg
	 */
	public void saveSendNewsMsg(NewsMessage msg){
		saveSendMsg(msg);
		sendMsgMapper.saveNewsMsgDetail(msg);
		for (Article article : msg.getArticles()) {
			article.setId(msg.getId());
			sendMsgMapper.saveNewsArticles(article);
		}
	}
	
	/**
	 * save send WeiXin text message
	 * @param msg
	 */
	public void saveSendTextMsg(TextMessage msg){
		saveSendMsg(msg);
		sendMsgMapper.saveTextMsgDetail(msg);
	}
	
	/**
	 * save WeiXin common receive message 
	 * @param msg
	 */
	private void saveRecvMsg(WeiXinMessage msg){
		recvMsgMapper.saveMsgDetail(msg);
	}
	
	/**
	 * save WeiXin common receive message 
	 * @param msg
	 */
	private void saveSendMsg(WeiXinMessage msg){
		sendMsgMapper.saveMsgDetail(msg);
	}
}
