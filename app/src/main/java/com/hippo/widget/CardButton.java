package com.hippo.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.Button;

import com.hippo.cardsalon.CardHelper;
import com.hippo.cardsalon.CardViewDelegate;

public class CardButton extends Button implements CardViewDelegate {

    private CardHelper mCardHelper;

    public CardButton(Context context) {
        super(context);
        init(context, null);
    }

    public CardButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public CardButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        mCardHelper = new CardHelper(this);
        mCardHelper.initialize(context, attrs);
    }

    @Override
    public void setBackgroundResource(int resid) {
        // Empty
    }

    @SuppressWarnings("deprecation")
    @Override
    public void setBackgroundDrawable(Drawable drawable) {
        // Empty
    }

    @Override
    public void setCardPadding(int left, int top, int right, int bottom) {
        if (mCardHelper != null) {
            mCardHelper.setPadding(left, top, right, bottom);
        }
    }

    @SuppressWarnings("deprecation")
    @Override
    public void setRawBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
    }

    @Override
    public void setCardRadius(float radius) {
        mCardHelper.setCardRadius(radius);
    }

    @Override
    public float getCardRadius() {
        return mCardHelper.getCardRadius();
    }

    @Override
    public void setCardBackgroundColor(int color) {
        mCardHelper.setCardBackgroundColor(color);
    }

    @Override
    public int getCardBackgroundColor() {
        return mCardHelper.getCardBackgroundColor();
    }

    @Override
    public void setCardBoundSize(float size) {
        mCardHelper.setCardBoundSize(size);
    }

    @Override
    public float getCardBoundSize() {
        return mCardHelper.getCardBoundSize();
    }

    @Override
    public void setCardBoundColor(int color) {
        mCardHelper.setCardBoundColor(color);
    }

    @Override
    public int getCardBoundColor() {
        return mCardHelper.getCardBoundColor();
    }

    @Override
    public void setCardElevation(float elevation) {
        mCardHelper.setCardElevation(elevation);
    }

    @Override
    public float getCardElevation() {
        return mCardHelper.getCardElevation();
    }
}
