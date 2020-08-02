/*
 * Copyright (c) 2019 Hemanth Savarala.
 *
 * Licensed under the GNU General Public License v3
 *
 * This is free software: you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by
 *  the Free Software Foundation either version 3 of the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY;
 * without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * See the GNU General Public License for more details.
 */

package io.github.muntashirakon.music.model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.DrawableRes;
import androidx.annotation.StringRes;

import io.github.muntashirakon.music.R;


public class CategoryInfo implements Parcelable {

    public static final Creator<CategoryInfo> CREATOR = new Creator<CategoryInfo>() {
        public CategoryInfo createFromParcel(Parcel source) {
            return new CategoryInfo(source);
        }

        public CategoryInfo[] newArray(int size) {
            return new CategoryInfo[size];
        }
    };
    public Category category;
    public boolean visible;

    public CategoryInfo(Category category, boolean visible) {
        this.category = category;
        this.visible = visible;
    }


    private CategoryInfo(Parcel source) {
        category = (Category) source.readSerializable();
        visible = source.readInt() == 1;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeSerializable(category);
        dest.writeInt(visible ? 1 : 0);
    }

    public enum Category {
        Home(R.id.action_home, R.string.home, R.drawable.asld_home),
        Songs(R.id.action_song, R.string.songs, R.drawable.asld_music_note),
        Albums(R.id.action_album, R.string.albums, R.drawable.asld_album),
        Artists(R.id.action_artist, R.string.artists, R.drawable.ic_artist),
        Playlists(R.id.action_playlist, R.string.playlists, R.drawable.ic_playlist_play),
        Genres(R.id.action_genre, R.string.genres, R.drawable.ic_guitar),
        Queue(R.id.action_playing_queue, R.string.queue, R.drawable.ic_queue_music),
        Folder(R.id.action_folder, R.string.folders, R.drawable.ic_folder);

        public final int icon;

        public final int id;

        public final int stringRes;

        Category(int id, @StringRes int stringRes, @DrawableRes int icon) {
            this.stringRes = stringRes;
            this.id = id;
            this.icon = icon;
        }
    }
}