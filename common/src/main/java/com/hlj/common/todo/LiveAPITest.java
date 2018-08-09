package com.hlj.common.todo;
//
//import com.google.gson.Gson;
//import org.junit.Ignore;
//import org.junit.Test;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import retrofit2.Call;

import java.util.LinkedList;

/**
 * @author liyufang
 * @since 2016-09-08
 */
public class LiveAPITest {
//    private static Logger logger = LoggerFactory.getLogger(LiveAPITest.class);
//    private static LiveAPI liveAPI = KsLiveUtils.getLiveAPI();
//    private static Gson gson = new Gson();
//    private static String liveApp = "live";
//
//    @Test
//    @Ignore
//    public void setPreset() throws Exception {
//        Preset preset = new Preset();
//        preset.app = liveApp;
//        preset.presetName = KsLiveUtils.defaultPresetName;
//        preset.description = "mivr live";
//        preset.outputList = new LinkedList<>();
//
//        Preset.Output output1080p = new Preset.Output();
//        output1080p.format = new Preset.Format();
//        output1080p.format.outputFormat = 264;
//        output1080p.format.vbr = 3000000;
//        output1080p.format.abr = 192000;
//        output1080p.format.fr = 25;
//        output1080p.format.remuxFlag = 0;
//        preset.outputList.add(output1080p);
//
//        Preset.Output output4k = new Preset.Output();
//        output4k.format = new Preset.Format();
//        output4k.format.outputFormat = 268;
//        output4k.format.vbr = 7000000;
//        output4k.format.abr = 320000;
//        output4k.format.fr = 30;
//        output4k.format.remuxFlag = 0;
//        preset.outputList.add(output4k);
//
//        logger.info("{}", gson.toJson(preset));
//
//        //System.exit(0);
//
//        Call<LiveAPI.SetPresetResponse> call = liveAPI.setPreset(KsLiveUtils.ACCESS_KEY, Integer.MAX_VALUE, KsLiveUtils.UNIQUE_NAME, preset);
//        LiveAPI.SetPresetResponse setPresetResponse = call.execute().body();
//        logger.info("set preset response:{}", gson.toJson(setPresetResponse));
//    }
//
//    @Test
//    @Ignore
//    public void getPresetList() throws Exception {
//        Call<LiveAPI.GetPresetListResponse> call = liveAPI.getPresetList(KsLiveUtils.ACCESS_KEY, Integer.MAX_VALUE, KsLiveUtils.UNIQUE_NAME, liveApp);
//        LiveAPI.GetPresetListResponse getPresetListResponse = call.execute().body();
//        logger.info("get preset list response:{}", gson.toJson(getPresetListResponse));
//        for (LiveAPI.GetPresetListResponse.PresetSummary presetSummary : getPresetListResponse.presetlist) {
//            Call<LiveAPI.GetPresetDetailResponse> getPresetDetailCall = liveAPI.getPresetDetail(KsLiveUtils.ACCESS_KEY, Integer.MAX_VALUE, KsLiveUtils.UNIQUE_NAME, liveApp, presetSummary.preset);
//            LiveAPI.GetPresetDetailResponse getPresetDetailResponse = getPresetDetailCall.execute().body();
//            logger.info("get preset detail response, preset:{} detail:{}",
//                    presetSummary.preset, gson.toJson(getPresetDetailResponse));
//        }
//    }
//
//    @Test
//    @Ignore
//    public void getPresetDetail() throws Exception {
//        Call<LiveAPI.GetPresetDetailResponse> call = liveAPI.getPresetDetail(KsLiveUtils.ACCESS_KEY, Integer.MAX_VALUE, KsLiveUtils.UNIQUE_NAME, liveApp, KsLiveUtils.defaultPresetName);
//        LiveAPI.GetPresetDetailResponse getPresetDetailResponse = call.execute().body();
//        logger.info("get preset detail response:{}", gson.toJson(getPresetDetailResponse));
//    }
//
//    @Test
//    @Ignore
//    public void delPreset() throws Exception {
//        Call<LiveAPI.DelPresetResponse> call = liveAPI.delPreset(KsLiveUtils.ACCESS_KEY, Integer.MAX_VALUE, KsLiveUtils.UNIQUE_NAME, liveApp, KsLiveUtils.defaultPresetName);
//        LiveAPI.DelPresetResponse delPresetResponse = call.execute().body();
//        logger.info("del preset response:{}", gson.toJson(delPresetResponse));
//    }
//
//    @Test
//    @Ignore
//    public void getStreamTranList() throws Exception {
//        Call<LiveAPI.GetStreamTranListResponse> call = liveAPI.getStreamTranList(KsLiveUtils.ACCESS_KEY, Integer.MAX_VALUE, KsLiveUtils.UNIQUE_NAME, liveApp, KsLiveUtils.defaultPresetName);
//        LiveAPI.GetStreamTranListResponse getStreamTranListResponse = call.execute().body();
//        logger.info("get stream tran list response:{}", gson.toJson(getStreamTranListResponse));
//    }

}
