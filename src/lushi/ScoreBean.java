package lushi;

import java.util.List;

/**
 * @author: create by hsw
 * @description: lushi
 * @date:2021/3/29
 **/
public class ScoreBean {
    String _id ;

    String openId;

    String nickName;

    List<CardBean> demonhunter;
    List<CardBean> druid;
    List<CardBean> hunter;
    List<CardBean> mage;
    List<CardBean> neutral;
    List<CardBean> paladin;
    List<CardBean> priest;
    List<CardBean> rogue;
    List<CardBean> shaman;
    List<CardBean> warlock;
    List<CardBean> warrior;

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public List<CardBean> getDemonhunter() {
        return demonhunter;
    }

    public void setDemonhunter(List<CardBean> demonhunter) {
        this.demonhunter = demonhunter;
    }

    public List<CardBean> getDruid() {
        return druid;
    }

    public void setDruid(List<CardBean> druid) {
        this.druid = druid;
    }

    public List<CardBean> getHunter() {
        return hunter;
    }

    public void setHunter(List<CardBean> hunter) {
        this.hunter = hunter;
    }

    public List<CardBean> getMage() {
        return mage;
    }

    public void setMage(List<CardBean> mage) {
        this.mage = mage;
    }

    public List<CardBean> getNeutral() {
        return neutral;
    }

    public void setNeutral(List<CardBean> neutral) {
        this.neutral = neutral;
    }

    public List<CardBean> getPaladin() {
        return paladin;
    }

    public void setPaladin(List<CardBean> paladin) {
        this.paladin = paladin;
    }

    public List<CardBean> getPriest() {
        return priest;
    }

    public void setPriest(List<CardBean> priest) {
        this.priest = priest;
    }

    public List<CardBean> getRogue() {
        return rogue;
    }

    public void setRogue(List<CardBean> rogue) {
        this.rogue = rogue;
    }

    public List<CardBean> getShaman() {
        return shaman;
    }

    public void setShaman(List<CardBean> shaman) {
        this.shaman = shaman;
    }

    public List<CardBean> getWarlock() {
        return warlock;
    }

    public void setWarlock(List<CardBean> warlock) {
        this.warlock = warlock;
    }

    public List<CardBean> getWarrior() {
        return warrior;
    }

    public void setWarrior(List<CardBean> warrior) {
        this.warrior = warrior;
    }
}
