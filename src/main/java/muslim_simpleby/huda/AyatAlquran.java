package muslim_simpleby.huda;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ProgressBar;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class AyatAlquran extends AppCompatActivity {
    private ListAyatAdapter mAdapter;
    private ArrayList<Ayat> mListAyat;
    private RecyclerView recyclerView;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ayat_alquran2);

        getSupportActionBar().setTitle("Surat Alquran");

        recyclerView= (RecyclerView)findViewById(R.id.recycler_view);
        progressBar= (ProgressBar)findViewById(R.id.progressbar);
        mListAyat = new ArrayList<Ayat>();
        mAdapter = new ListAyatAdapter(mListAyat);

        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, mLayoutManager.getOrientation()));
        recyclerView.setAdapter(mAdapter);
        loadData();
    }
    private void loadData(){
        try {
            String url = "/surat";
            ClientAsyncTask1 task = new ClientAsyncTask1(this, url, new ClientAsyncTask1.OnPostExecuteListener() {
                @Override
                public void onPostExecute(String result) {
                    Log.d("Ayat Alquran", result);
                    try {
                        JSONObject jsonObject = new JSONObject(result);
                        JSONArray jsonArray = jsonObject.getJSONArray("hasil");
                        for (int i = 0; i< jsonArray.length(); i++){
                            JSONObject object = jsonArray.getJSONObject(i);
                            Ayat ayat = new Ayat();
                            ayat.nomor = object.getString("nomor");
                            ayat.nama = object.getString("nama");
                            ayat.asma = object.getString("asma");
                            ayat.name = object.getString("name");
                            ayat.start = object.getString("start");
                            ayat.ayat = object.getString("ayat");
                            ayat.type = object.getString("type");
                            ayat.urut = object.getString("urut");
                            ayat.rukuk = object.getString("rukuk");
                            ayat.arti = object.getString("arti");
                            mListAyat.add(ayat);
                        }
                        mAdapter.notifyDataSetChanged();
                    }catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            });
            task.setmProgress(this.progressBar);
            task.execute();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

