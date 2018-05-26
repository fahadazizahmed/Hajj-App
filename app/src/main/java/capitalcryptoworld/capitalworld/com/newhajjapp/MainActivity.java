package capitalcryptoworld.capitalworld.com.newhajjapp;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;

import capitalcryptoworld.capitalworld.com.newhajjapp.Adapter.AccomodationDetailAdapter;
import capitalcryptoworld.capitalworld.com.newhajjapp.Controller.RestManager;

public class MainActivity extends AppCompatActivity   {

    private RecyclerView mRecyclerView;
    private RestManager mManager;
    private AccomodationDetailAdapter mFlowerAdapter;
    private SwipeRefreshLayout swipeRefreshLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*configViews();
        mManager=new RestManager();
        Call<AccomodationList> listcall = mManager.getServices().accomodation();
        listcall.enqueue(new Callback<AccomodationList>() {
            @Override
            public void onResponse(Call<AccomodationList> call, Response<AccomodationList> response) {
                AccomodationList accomodationList =    response.body();
                Log.d("rescc",            accomodationList.is__abp()+"");
                Log.d("resccc",            accomodationList.isSuccess()+"");
                AccomodationList.Result[] result = accomodationList.getResult();
                for(int i = 0;i<result.length;i++){
                    AccomodationList.Result flower = result[1];
                    Log.d("camador",result[1].getName()+"");
                    mFlowerAdapter.addFlower(flower);

                }

            }

            @Override
            public void onFailure(Call<AccomodationList> call, Throwable t) {

            }
        });

        /*
        listcall.enqueue(new Callback<List<Flower>>() {
            @Override
            public void onResponse(Call<List<Flower>> call, Response<List<Flower>> response) {
                if(response.isSuccessful()){
                    List<Flower> flowerlist= response.body();
                    for(int i = 0;i<flowerlist.size();i++){
                        Flower flower = flowerlist.get(i);
                        mFlowerAdapter.addFlower(flower);

                    }

                }
                else{
                    int sc = response.code();
                    switch (sc){

                    }
                }
            }

            @Override
            public void onFailure(Call<List<Flower>> call, Throwable t) {

            }
        });


    }

    private void configViews() {
        mRecyclerView=(RecyclerView)findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setRecycledViewPool(new RecyclerView.RecycledViewPool());
        mFlowerAdapter = new AccomodationDetailAdapter();
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL,false));

       // mRecyclerView.setAdapter( mFlowerAdapter);

    }


 */
    }
}
