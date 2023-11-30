package be.ehb.databass.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import be.ehb.databass.model.Fish;
import be.ehb.databass.model.FishDataBass;

public class FishViewModel extends AndroidViewModel {

    private ExecutorService mExecutorService;
    private FishDataBass mDataBass;

    public FishViewModel(@NonNull Application application) {
        super(application);
        mExecutorService = Executors.newFixedThreadPool(2);
        mDataBass = FishDataBass.getInstance(application);
    }

    public void insertFish(Fish f){
        //kies uw favoriete manier
        //lambda
        mExecutorService.execute(()->{
            mDataBass.getFishDAO().insertFish(f);
        });

        //anonymous inner class
        /*
        mExecutorService.execute(new Runnable() {
            @Override
            public void run() {
                mDataBass.getFishDAO().insertFish(f);
            }
        });
        */
    }

    public LiveData<List<Fish>> soLongAndThanksForAllTheFish(){
        return mDataBass.getFishDAO().getAllFish();
    }


}
