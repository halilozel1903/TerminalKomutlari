package hsmnzaydn.serkanozaydin.net.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;


import android.view.View;
import android.view.ViewGroup;


import com.gturedi.views.StatefulLayout;
import com.orangegangsters.github.swipyrefreshlayout.library.SwipyRefreshLayout;
import com.orangegangsters.github.swipyrefreshlayout.library.SwipyRefreshLayoutDirection;

import java.util.List;

import hsmnzaydn.serkanozaydin.net.Adapter.onlineKomutlarAdapter;
import hsmnzaydn.serkanozaydin.net.DrawerActivity;
import hsmnzaydn.serkanozaydin.net.KurucuClasslar.onlineKomutlar;
import hsmnzaydn.serkanozaydin.net.MysqlConnect;
import hsmnzaydn.serkanozaydin.net.Network.Network;
import hsmnzaydn.serkanozaydin.net.Network.NetworkHandler;
import hsmnzaydn.serkanozaydin.net.R;


/**
 * Created by hsmnzaydn on 23.06.2017.
 */

public class onlineKomutlarReycliviewFragment extends Fragment {
private View root;
    private RecyclerView recyclerView;
    private SwipyRefreshLayout refreshLayout;







    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        getActivity().setTitle(getString(R.string.online_komutlar));

        root=inflater.inflate(R.layout.fragment_reycliview_onlinekomutlar,container,false);


        recyclerView= (RecyclerView) root.findViewById(R.id.fragment_reycliview_onlinekomutlar_reycliview);
        final StatefulLayout stateful = (StatefulLayout)root. findViewById(R.id.stateful);
        refreshLayout= (SwipyRefreshLayout) root.findViewById(R.id.swipyrefreshlayout);

       stateful.showLoading(getString(R.string.yukleniyor));
        Network network=new Network(getActivity());
        network.getJsonDatas(new NetworkHandler() {
            @Override
            public void getCommandList(List<onlineKomutlar> komutList) {
                onlineKomutlarAdapter adapter=new onlineKomutlarAdapter(komutList,getContext());

                recyclerView.setHasFixedSize(true);

                recyclerView.setAdapter(adapter);
                adapter.notifyDataSetChanged();

            }
        });

       stateful.showContent();



        refreshLayout.setOnRefreshListener(new SwipyRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh(SwipyRefreshLayoutDirection direction) {
                MysqlConnect connect=new MysqlConnect(getContext(),recyclerView,stateful);
                connect.VeriGetirRefresh();
                refreshLayout.setRefreshing(false);

            }
        });



        final LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());

        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        layoutManager.scrollToPosition(0);

        recyclerView.setLayoutManager(layoutManager);


        recyclerView.setItemAnimator(new DefaultItemAnimator());


        return root;
    }




}
