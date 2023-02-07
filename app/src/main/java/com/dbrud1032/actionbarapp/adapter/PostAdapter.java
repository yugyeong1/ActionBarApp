package com.dbrud1032.actionbarapp.adapter;

// 1. RecyclerView.Adapter 를 상속받는다.

// 2. 상속받은 클래스가 abstract 이므로, unimplemented method 오버라이드!


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.dbrud1032.actionbarapp.R;
import com.dbrud1032.actionbarapp.model.Post;

import java.util.ArrayList;

// 6. RecyclerView.Adapter 의 데이터 타입을 적어주어야 한다.
//    우리가 만든 ViewHolder 로 적는다.


// 7. 빨간색 에러가 뜨면, 우리가 만든 ViewHolder 로
// onCreateViewHolder, onBindViewHolder 변경해준다.

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.ViewHolder> {

    // 5. 어댑터 클래스의 멤버변수와 생성자를 만들어 준다.

    Context context;
    ArrayList<Post> postList;

    public PostAdapter(Context context, ArrayList<Post> postList) {
        this.context = context;
        this.postList = postList;
    }

    // 8. 오버라이드 함수 3개를 전부 구현 해주면 끝!
    @NonNull
    @Override
    public PostAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // xml 파일을 연결하는 작업
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.post_row, parent, false);
        return new PostAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PostAdapter.ViewHolder holder, int position) {
        // 뷰에 데이터를 셋팅한다!
        Post post = postList.get(position);

        holder.txtTitle.setText( post.title );
        holder.txtBody.setText( post.body );

    }

    @Override
    public int getItemCount() {
        return postList.size();
    }

    // 3. ViewHolder 클래스를 만든다.
    //      이 클래스는 row.xml 화면에 있는 뷰를 연결시키는 클래스다.
    // RecyclerView.ViewHolder 상속받는다.

    // 4. 생성자를 만든다.
    //    생성자에서, 뷰를 연결시키는 코드를 작성하고,
    //    클릭 이벤트도 작성한다.

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView txtTitle;
        TextView txtBody;
        ImageView imgDelete;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtTitle = itemView.findViewById(R.id.txtTitle);
            txtBody = itemView.findViewById(R.id.txtBody);
            imgDelete = itemView.findViewById(R.id.imgDelete);

        }
    }
}
