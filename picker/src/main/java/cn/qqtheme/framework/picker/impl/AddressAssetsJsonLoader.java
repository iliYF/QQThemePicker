package cn.qqtheme.framework.picker.impl;

import android.content.Context;
import android.content.res.AssetManager;
import android.os.AsyncTask;
import androidx.annotation.WorkerThread;
import androidx.fragment.app.FragmentActivity;
import android.util.Log;

import cn.qqtheme.framework.picker.contract.AddressDataLoadListener;
import cn.qqtheme.framework.picker.contract.AddressJsonLoader;
import cn.qqtheme.framework.picker.contract.AddressJsonParser;
import cn.qqtheme.framework.picker.entity.ProvinceEntity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/**
 * 使用默认的地址数据
 *
 * @author <a href="mailto:1032694760@qq.com">liyujiang</a>
 * @date 2019/6/17 17:15
 * @see AddressDataLoadTask
 */
@SuppressWarnings("unused")
public class AddressAssetsJsonLoader implements AddressJsonLoader {
    private static final String ASSETS_JSON = "china_administrative_division.json";
    private static final String TAG = AddressAssetsJsonLoader.class.getSimpleName();
    private FragmentActivity activity;

    public AddressAssetsJsonLoader(FragmentActivity activity) {
        this.activity = activity;
    }

    @Override
    public void loadJson(final AddressDataLoadListener loadListener,
                         final AddressJsonParser jsonParser) {
        new AddressDataLoadTask(activity, loadListener).execute();
    }

    @WorkerThread
    private static List<ProvinceEntity> loadFromAssets(Context context) {
        StringBuilder stringBuilder = new StringBuilder();
        try {
            AssetManager assetManager = context.getAssets();
            BufferedReader bf = new BufferedReader(new InputStreamReader(
                    assetManager.open(ASSETS_JSON)));
            String line;
            while ((line = bf.readLine()) != null) {
                stringBuilder.append(line);
            }
        } catch (IOException e) {
            Log.e(TAG, e.getMessage());
            return new ArrayList<>();
        }
        String json = stringBuilder.toString();
        try {
            return new AddressOrgJsonParser().parseJson(json);
        } catch (Exception e) {
            Log.e(TAG, e.getMessage());
            return new ArrayList<>();
        }
    }

    static class AddressDataLoadTask extends AsyncTask<Void, Void, List<ProvinceEntity>> {
        private WeakReference<FragmentActivity> weakReference;
        private AddressDataLoadListener loadListener;

        AddressDataLoadTask(FragmentActivity activity, AddressDataLoadListener loadListener) {
            this.weakReference = new WeakReference<>(activity);
            this.loadListener = loadListener;
        }

        @Override
        protected void onPreExecute() {
            FragmentActivity activity = weakReference.get();
            if (activity == null) {
                return;
            }
            if (loadListener != null) {
                loadListener.onDataLoadStart();
            }
        }

        @Override
        protected List<ProvinceEntity> doInBackground(Void... params) {
            FragmentActivity activity = weakReference.get();
            if (activity == null) {
                return null;
            }
            return loadFromAssets(activity);
        }

        @Override
        protected void onPostExecute(List<ProvinceEntity> data) {
            FragmentActivity activity = weakReference.get();
            if (activity == null) {
                return;
            }
            if (data == null || data.size() == 0) {
                if (loadListener != null) {
                    loadListener.onDataLoadFailure();
                }
                return;
            }
            if (loadListener != null) {
                loadListener.onDataLoadSuccess(data);
            }
        }

    }

}
