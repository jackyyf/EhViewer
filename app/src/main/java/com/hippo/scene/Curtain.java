/*
 * Copyright (C) 2015 Hippo Seven
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.hippo.scene;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

public abstract class Curtain {

    private int mPreviousSceneId;

    void setPreviousScene(@Nullable Scene pScene) {
        if (pScene == null) {
            mPreviousSceneId = -1;
        } else {
            mPreviousSceneId = pScene.getId();
        }
    }

    boolean isPreviousScene(@Nullable Scene scene) {
        return scene != null && scene.getId() == mPreviousSceneId;
    }

    /**
     * @return true if can NOT still run when previous scene changed
     */
    protected boolean specifyPreviousScene() {
        return true;
    }

    protected void onRebirth() {
    }

    /**
     * Called when
     *
     * @param enter the scene on the top of the scene stack
     * @param exit the scene behind the enter scene
     */
    public abstract void open(@NonNull Scene enter, @NonNull Scene exit);

    public abstract void close(@NonNull Scene enter, @NonNull Scene exit);

    /**
     * End open or close animation
     */
    public abstract void endAnimation();

    /**
     * Is open or close animation running
     */
    public abstract boolean isInAnimation();

    protected void dispatchOpenFinished(@NonNull Scene enter, @NonNull Scene exit) {
        enter.openFinished();
    }

    protected void dispatchCloseFinished(@NonNull Scene enter, @NonNull Scene exit) {
        exit.closeFinished();
    }

    protected void hideSceneOnOpen(@NonNull Scene exit) {
        exit.setHide(true);
    }

    protected void showSceneOnClose(@NonNull Scene enter) {
        enter.setHide(false);
    }
}
