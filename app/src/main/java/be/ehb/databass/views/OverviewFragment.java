package be.ehb.databass.views;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

import be.ehb.databass.R;
import be.ehb.databass.model.Fish;
import be.ehb.databass.viewmodel.FishViewModel;
import be.ehb.databass.views.utils.FishAdapter;

public class OverviewFragment extends Fragment {


    public OverviewFragment() {
    }

    public static OverviewFragment newInstance(){
        return new OverviewFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_overview, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        RecyclerView rvData = view.findViewById(R.id.rv_data);

        FishAdapter adapter = new FishAdapter();
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false);

        rvData.setAdapter(adapter);
        rvData.setLayoutManager(layoutManager);

        FishViewModel viewModel = new ViewModelProvider(getActivity()).get(FishViewModel.class);

        viewModel.soLongAndThanksForAllTheFish().observe(getViewLifecycleOwner(), (List<Fish> items) -> {
           adapter.addItems(items);
        });

        FloatingActionButton fab = view.findViewById(R.id.btn_new_fish);
        fab.setOnClickListener( (View v) -> {
            Navigation.findNavController(view).navigate(R.id.action_overviewFragment_to_newFishFragment);
        });
    }
}
