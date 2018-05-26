package capitalcryptoworld.capitalworld.com.newhajjapp.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import capitalcryptoworld.capitalworld.com.newhajjapp.Model.AccomodationList;

import capitalcryptoworld.capitalworld.com.newhajjapp.Model.AllAccomodation;
import capitalcryptoworld.capitalworld.com.newhajjapp.R;


/**
 * Created by Fahad Aziz on 22/05/2018.
 */

public class AccomodationDetailAdapter extends RecyclerView.Adapter<AccomodationDetailAdapter.Holder> {
    private List<AllAccomodation> ListAccomodation;
    private int previousposition=0;
    private final FlowerClickListener mlistener;
    //public static final String TAG=FlowerAdapter.class.getSimpleName();

    public AccomodationDetailAdapter(FlowerClickListener listener)
    {
        ListAccomodation = new ArrayList<>();
        mlistener = listener;

    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View row = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row,null,false);
        return new Holder(row);


    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {
       AllAccomodation userAccomdationList = ListAccomodation.get(position);
        holder.mName.setText(userAccomdationList.getName());
        holder.mLocation.setText(userAccomdationList.getLocation());
        holder.mAvailable.setText(userAccomdationList.getAvailable()+"");
        /*holder.mPrice.setText("$"+Double.toString(currFlower.getPrice()));
        Picasso.with(holder.itemView.getContext()).load("http://services.hanselandpetal.com/photos/"+currFlower.getPhoto()).into(holder.mPhoto);
        if(position>previousposition){//We are scrolling down
            AnimationUtils.animate(holder,true);
        }
        else {
            AnimationUtils.animate(holder,false);
        }
        position=previousposition;
*/

    }

    @Override
    public int getItemCount() {
        return ListAccomodation.size();
    }

    public void addFlower(AllAccomodation allAccomodation) {

        ListAccomodation.add(allAccomodation);
        notifyDataSetChanged();
    }

     public AllAccomodation getAccomodation(int position)
     {
         return ListAccomodation.get(position);
     }

    public class Holder extends RecyclerView.ViewHolder implements View.OnClickListener {
       // private ImageView mPhoto;
        private TextView mName,mAvailable,mLocation;
        public Holder(View itemView) {
            super(itemView);
          //  mPhoto=(ImageView)itemView.findViewById(R.id.flowerPhoto);
            mName=(TextView)itemView.findViewById(R.id.tx_name);
            mLocation=(TextView)itemView.findViewById(R.id.tx_location);
            mAvailable=(TextView)itemView.findViewById(R.id.tx_availabe);
            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View view) {
            mlistener.onClick(getLayoutPosition());

        }}
    public interface FlowerClickListener{
        void onClick(int position);

    }
}



