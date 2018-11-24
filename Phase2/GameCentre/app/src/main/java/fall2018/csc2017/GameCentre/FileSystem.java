package fall2018.csc2017.GameCentre;

import android.content.Context;
import android.util.Log;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import static android.content.Context.MODE_PRIVATE;

class FileSystem {

    /**
     * Load account manager from fileName.
     *
     * @param context the context writing the file.
     */
    AccountManager loadAccount(Context context) {

        try {
            InputStream inputStream = context.openFileInput(StartingLoginActivity.SAVE_ACCOUNT_MANAGER);
            AccountManager accountManager;
            if (inputStream != null) {
                ObjectInputStream input = new ObjectInputStream(inputStream);
                accountManager = (AccountManager) input.readObject();
                inputStream.close();
                return accountManager;
            }
        } catch (FileNotFoundException e) {
            Log.e("login activity", "File not found: " + e.toString());
        } catch (IOException e) {
            Log.e("login activity", "Can not read file: " + e.toString());
        } catch (ClassNotFoundException e) {
            Log.e("login activity", "File contained unexpected " +
                    "data type: " + e.toString());
        }
        return null;
    }

    /**
     * Load scoreboard from fileName.
     *
     * @param context the context.
     */
    Scoreboard loadScoreboard(Context context) {

        try {
            InputStream inputStream = context.openFileInput(StartingLoginActivity.SAVE_SCOREBOARD);
            Scoreboard scoreBoard;
            if (inputStream != null) {
                ObjectInputStream input = new ObjectInputStream(inputStream);
                scoreBoard = (Scoreboard) input.readObject();
                inputStream.close();
                return scoreBoard;
            }
        } catch (FileNotFoundException e) {
            Log.e("login activity", "File not found: " + e.toString());
        } catch (IOException e) {
            Log.e("login activity", "Can not read file: " + e.toString());
        } catch (ClassNotFoundException e) {
            Log.e("login activity", "File contained unexpected " +
                    "data type: " + e.toString());
        }
        return null;
    }

    /**
     * Save the account manager.
     *
     * @param context the context writing the file.
     */
    public void saveAccount(Context context, AccountManager accountManager) {
        try {
            ObjectOutputStream outputStream = new ObjectOutputStream(
                    context.openFileOutput(StartingLoginActivity.SAVE_ACCOUNT_MANAGER, MODE_PRIVATE));
            outputStream.writeObject(accountManager);
            outputStream.close();
        } catch (IOException e) {
            Log.e("Exception", "File write failed: " + e.toString());
        }
    }

    /**
     * Save the score board.
     *
     * @param context the context writing the file.
     */
    public void saveScoreBoard(Context context, Scoreboard scoreboard) {
        try {
            ObjectOutputStream outputStream = new ObjectOutputStream(
                    context.openFileOutput(StartingLoginActivity.SAVE_ACCOUNT_MANAGER, MODE_PRIVATE));
            outputStream.writeObject(scoreboard);
            outputStream.close();
        } catch (IOException e) {
            Log.e("Exception", "File write failed: " + e.toString());
        }
    }
}
