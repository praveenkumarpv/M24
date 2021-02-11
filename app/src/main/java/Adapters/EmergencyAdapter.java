package Adapters;


import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;

import Modalclass.EmergencyServices;

public class EmergencyAdapter extends FirestoreRecyclerAdapter<EmergencyServices, EmergencyAdapter.viewholder> {

    /**
     * Create a new RecyclerView adapter that listens to a Firestore Query.  See {@link
     * FirestoreRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public EmergencyAdapter(@NonNull FirestoreRecyclerOptions<EmergencyServices> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull viewholder viewholder, int i, @NonNull EmergencyServices emergencyServices) {

    }

    @NonNull
    @Override
    public viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }
    public  class viewholder extends RecyclerView.ViewHolder {
        

        public viewholder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
