package com.xianhe.mis.input;

import javafx.util.Callback;

public abstract class GridCallback<S,T> implements Callback<S,T>  {
	int index = 0;
	
	public GridCallback(int index) {
        this.index = index;
    }

}
