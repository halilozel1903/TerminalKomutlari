package hsmnzaydn.serkanozaydin.net.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;


import android.view.View;
import android.view.ViewGroup;


import com.gturedi.views.StatefulLayout;
import com.orangegangsters.github.swipyrefreshlayout.library.SwipyRefreshLayout;
import com.orangegangsters.github.swipyrefreshlayout.library.SwipyRefreshLayoutDirection;

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
        root=inflater.inflate(R.layout.fragment_reycliview_onlinekomutlar,container,false);


        recyclerView= (RecyclerView) root.findViewById(R.id.fragment_reycliview_onlinekomutlar_reycliview);
        final StatefulLayout stateful = (StatefulLayout)root. findViewById(R.id.stateful);
        refreshLayout= (SwipyRefreshLayout) root.findViewById(R.id.swipyrefreshlayout);

        MysqlConnect connect=new MysqlConnect(getContext(),recyclerView,stateful);
        connect.VeriGetir();

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



        return root;
    }




}
