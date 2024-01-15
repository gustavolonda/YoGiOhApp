package com.fisagrp.yugiohapp.adapter;

import com.fisagrp.yugiohapp.data.entity.BanlistInfoEntity;
import com.fisagrp.yugiohapp.model.BanlistInfo;
import static com.fisagrp.yugiohapp.util.StringUtil.EMPTY;

public class BanlistInfoAdapter {
    public static BanlistInfoEntity toBanlistInfoEntity(BanlistInfo banlistInfo){
        if (banlistInfo == null)
            return null;
        BanlistInfoEntity banlistInfoEntity = new BanlistInfoEntity();
        banlistInfoEntity.banOcg = banlistInfo.banOcg != null ? banlistInfo.banOcg: EMPTY;
        banlistInfoEntity.banTcg = banlistInfo.banTcg != null ? banlistInfo.banTcg: EMPTY;
        return banlistInfoEntity;
    }

    public static BanlistInfo toBanlistInfo(BanlistInfoEntity banlistInfoEntity){
        if (banlistInfoEntity == null)
            return null;
        BanlistInfo banlistInfo = new BanlistInfo();
        banlistInfo.banOcg      = banlistInfoEntity.banOcg;
        banlistInfo.banTcg      = banlistInfoEntity.banTcg;
        return banlistInfo;
    }
}
