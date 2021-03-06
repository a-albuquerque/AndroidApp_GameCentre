/*
Controller
 */
package fall2018.csc2017.GameCentre;

import android.content.Context;

class SlidingTileScoreActivityController {
    /**
     * The file system.
     */
    private FileSystem fileSystem;

    /**
     * Creates a new controller for the activity.
     * @param fileSystem the file system.
     */
    SlidingTileScoreActivityController(FileSystem fileSystem) {
        this.fileSystem = fileSystem;
    }

    /**
     * Listens for an onCreate call in the activity to return the top scores in SlidingTiles.
     *
     * @param context the current Activity.
     * @return StringBuilder that will be displayed to the user.
     */
    StringBuilder onCreateListener(Context context) {
        Scoreboard slidingTileScoreboard;
        slidingTileScoreboard = fileSystem.loadScoreboard(context,
                StartingLoginActivity.SAVE_SLIDING_SCOREBOARD);
        return slidingTileScoreboard.createTopScoreText();
    }
}
