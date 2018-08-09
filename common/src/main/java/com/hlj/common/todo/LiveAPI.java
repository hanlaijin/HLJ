package com.hlj.common.todo;

//import retrofit2.Call;
//import retrofit2.http.Body;
//import retrofit2.http.GET;
//import retrofit2.http.POST;
//import retrofit2.http.Query;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liyufang
 * @since 2016-09-07
 */
public interface LiveAPI {
//
//    class SetPresetResponse {
//        public int errno = 0;
//        public String errmsg = "";
//    }
//
//    @POST("/livetran/preset")
//    Call<SetPresetResponse> setPreset(
//            @Query("accesskey") String accessKey,
//            @Query("expire") long expire,
//            @Query("uniqname") String uniqueName,
//            @Body Preset preset
//    );
//
//    class GetPresetListResponse {
//        class PresetSummary {
//            public String preset = "";
//            public String description = "";
//        }
//
//        public int errno = 0;
//        public String errmsg = "";
//        public List<PresetSummary> presetlist = new ArrayList<>();
//    }
//
//    @GET("/livetran/getpresetlist")
//    Call<GetPresetListResponse> getPresetList(
//            @Query("accesskey") String accessKey,
//            @Query("expire") long expire,
//            @Query("uniqname") String uniqueName,
//            @Query("app") String app
//    );
//
//    class GetPresetDetailResponse {
//        class PresetDetail {
//            public String description = "";
//            public List<PresetDetailOutput> output = new ArrayList<>();
//        }
//        public class PresetDetailOutput {
//            public PresetDetailOutputFormat format = new PresetDetailOutputFormat();
//        }
//        public class PresetDetailOutputFormat {
//            public String output_format = "";
//            public long vbr = 0;
//            public long abr = 0;
//            public int fr = 0;
//            public int remuxflag = 0;
//        }
//        public int errno = 0;
//        public String errmsg = "";
//        public PresetDetail presetdetail = new PresetDetail();
//    }
//
//    @GET("/livetran/getpresetdetail")
//    Call<GetPresetDetailResponse> getPresetDetail(
//            @Query("accesskey") String accessKey,
//            @Query("expire") long expire,
//            @Query("uniqname") String uniqueName,
//            @Query("app") String app,
//            @Query("preset") String preset
//    );
//
//    class DelPresetResponse {
//        public int errno = 0;
//        public String errmsg = "";
//    }
//
//    @GET("/livetran/delpreset")
//    Call<DelPresetResponse> delPreset(
//            @Query("accesskey") String accessKey,
//            @Query("expire") long expire,
//            @Query("uniqname") String uniqueName,
//            @Query("app") String app,
//            @Query("preset") String preset
//    );
//
//    class GetStreamTranListResponse {
//        class TranList {
//            public int format = 0;
//            public int status = 0;
//        }
//        public int errno = 0;
//        public String errmsg = "";
//        public List<TranList> tranlist = new ArrayList<>();
//    }
//
//    @GET("/livetran/delpreset")
//    Call<GetStreamTranListResponse> getStreamTranList(
//            @Query("accesskey") String accessKey,
//            @Query("expire") long expire,
//            @Query("uniqname") String uniqueName,
//            @Query("app") String app,
//            @Query("preset") String preset
//    );
}
