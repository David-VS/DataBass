package be.ehb.databass.views;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import be.ehb.databass.R;
import be.ehb.databass.model.Fish;
import be.ehb.databass.viewmodel.FishViewModel;

public class NewFishFragment extends Fragment {

    public NewFishFragment() {
    }

    public static NewFishFragment newInstance(){
        return new NewFishFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_new_fish, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        FishViewModel viewModel = new ViewModelProvider(getActivity()).get(FishViewModel.class);

        EditText nameET = view.findViewById(R.id.et_name);
        EditText colorET = view.findViewById(R.id.et_color);
        Button saveBtn = view.findViewById(R.id.btn_save);

        saveBtn.setOnClickListener( (View v)->{
            String name = nameET.getText().toString();
            String color = colorET.getText().toString();
            Fish toSave = new Fish(name, color);
            viewModel.insertFish(toSave);

            Navigation.findNavController(view).navigateUp();
        } );

    }
}
