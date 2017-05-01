package lyricsrest

import com.omt.lyrics.SearchLyrics
import com.omt.lyrics.beans.Lyrics
import com.omt.lyrics.beans.LyricsServiceBean
import com.omt.lyrics.exception.SearchLyricsException

class SearchController {

    def index() {

        def song = params['song']
        def artist = params['artist']

        SearchLyrics sl = new SearchLyrics();
        LyricsServiceBean bean = new LyricsServiceBean();

        bean.setSongName(song);
        bean.setSongAlbum(artist);

        List<Lyrics> lyrics = null;
        try {
            lyrics = sl.searchLyrics(bean);
        } catch (SearchLyricsException e) {
            // TODO Auto-generated catch block
        }

        return lyrics

    }
}
