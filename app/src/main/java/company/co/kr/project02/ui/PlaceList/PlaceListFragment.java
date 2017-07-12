package company.co.kr.project02.ui.PlaceList;

/**
 * Created by Dongjin on 2017. 7. 12..
 */

import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.design.widget.TabLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import company.co.kr.project02.R;
import company.co.kr.project02.model.Item;

public class PlaceListFragment extends Fragment {
    private static final String TAG = "PLACE_LIST_FRAGMENT";

    private LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(),
            LinearLayoutManager.VERTICAL, false);
    private StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2, 1);

    private static final int LINEAR_TYPE = 0;
    private static final int STAGGERED_TYPE = 1;
    private static int type = 1;

    private List<Item> itemList = new ArrayList<>();

    @BindView(R.id.recvPlaceList)
    RecyclerView recvPlaceList;

    @BindView(R.id.toolType)
    Toolbar toolType;

    @BindView(R.id.tabLayout)
    TabLayout tabLayout;

    public static PlaceListFragment newInstance() {
        return new PlaceListFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        itemList = makePlaceListItems();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_place_list, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
        setTabLayout();
        setRecyclerView(LINEAR_TYPE);
        imgBtnChangeRecyclerType(view);
    }

    /*
    * Set icons for each tab from @array/tab_items
    * */
    private void setTabLayout() {
        TypedArray tabIcons = getResources().obtainTypedArray(R.array.tab_items);

        for(int idx = 0; idx < tabLayout.getTabCount(); idx++) {
            tabLayout.getTabAt(idx).setIcon(tabIcons.getResourceId(idx, R.drawable.selector_tab_distance));
        }
    }

    private void setRecyclerView(int type) {
        PlaceListAdapter placeListAdapter = new PlaceListAdapter(getContext(), itemList,
                new PlaceListAdapter.PlaceAdapterOnClickHandler() {
                    @Override
                    public void onClick(String msg) {
                        Toast.makeText(getContext(), msg, Toast.LENGTH_SHORT).show();
                    }
                });

        if(type == LINEAR_TYPE) {
            recvPlaceList.setLayoutManager(linearLayoutManager);
        }
        else {
            recvPlaceList.setLayoutManager(staggeredGridLayoutManager);
        }

        recvPlaceList.setAdapter(placeListAdapter);
    }

    /*
    * Action to change recycler view type
    * */
    @OnClick(R.id.imgBtnChangeRecyclerType)
    public void imgBtnChangeRecyclerType(View view) {
        view.setSelected(!view.isSelected());

        type = (type+1) % 2;
        setRecyclerView(getRecyclerItemType(type));
    }

    private int getRecyclerItemType(int type) {
        if(type == 0)
            return LINEAR_TYPE;
        else if(type == 1)
            return STAGGERED_TYPE;
        return LINEAR_TYPE;
    }

    /*
    * Make item list
    * */
    private List<Item> makePlaceListItems() {
        List<Item> itemList = new ArrayList<>();
        itemList.add(new Item(R.drawable.ic_distance_selected, "해우소", "꿀막걸리", false));
        itemList.add(new Item(R.drawable.ic_distance_selected, "삼교리동치미막국", "막국", false));
        itemList.add(new Item(R.drawable.ic_distance_selected, "우왕", "막국", false));
        itemList.add(new Item(R.drawable.ic_distance_selected, "예에", "막국", false));
        itemList.add(new Item(R.drawable.ic_distance_selected, "오호", "막국", false));

        return itemList;
    }

}