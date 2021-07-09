package com.example.Meetstranger;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;

import org.webrtc.RendererCommon.ScalingType;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Fragment for call control.
 */
@SuppressLint("ValidFragment")
public class CallFragment extends Fragment {

    public CircleImageView circleImageView;
    public TextView userName;

    @SuppressLint("StaticFieldLeak")
    public static TextView callTime;
    //private ImageButton cameraSwitchButton;
    //private ImageButton videoScalingButton;
    private ImageButton toggleMuteButton;
    private ImageButton toggleSpeakerButton;

    private TextView captureFormatText;
    private SeekBar captureFormatSlider;
    private OnCallEvents callEvents;
    private ScalingType scalingType;
    private boolean videoCallEnabled = true;
    View controlView;

    public TextView connecingTextView;

    //admob
    //private AdView adView;

    public static boolean isCalling;

    private Handler handler;
    private int sec,min,hours;

    @SuppressLint("StaticFieldLeak")
    public static ProgressBar progressBar;

    /**
     * Call control interface for container activity.
     */
    @SuppressLint("ValidFragment")
    public CallFragment(boolean videocall) {
        videoCallEnabled = videocall;
    }

    public interface OnCallEvents {
        void onCallHangUp();

        void onCameraSwitch();

        void onVideoScalingSwitch(ScalingType scalingType);

        void onCaptureFormatChange(int width, int height, int framerate);

        boolean onToggleMic();

        boolean onToggleSpeaker();

        void setOpponentUserImage();
    }

    // onCreateView method to create and execute fragment_call layout xml file
    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){

        controlView = inflater.inflate(R.layout.fragment_call, container, false);

        circleImageView = controlView.findViewById(R.id.circle_image_view);
        userName = controlView.findViewById(R.id.username);
        callEvents.setOpponentUserImage();


        // Create UI controls.
        callTime = controlView.findViewById(R.id.contact_name_call);
        ImageButton disconnectButton = controlView.findViewById(R.id.button_call_disconnect);
        // cameraSwitchButton = controlView.findViewById(R.id.button_call_switch_camera);
        // videoScalingButton = controlView.findViewById(R.id.button_call_scaling_mode);
        toggleMuteButton = controlView.findViewById(R.id.button_call_toggle_mic);
        toggleSpeakerButton = controlView.findViewById(R.id.button_call_toggle_speaker);
        captureFormatText = controlView.findViewById(R.id.capture_format_text_call);
        captureFormatSlider = controlView.findViewById(R.id.capture_format_slider_call);
        progressBar = (ProgressBar)controlView.findViewById(R.id.searching_call_progress_bar);
        //profilepic = controlView.findViewById(R.id.profile);

        connecingTextView = (TextView)controlView.findViewById(R.id.call_activity_cooneting);
        handler = new Handler();
        isCalling=false;
        sec=0;
        min=0;
        hours=0;

        // Add buttons click events.
        disconnectButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callEvents.onCallHangUp();
            }
        });

        /* cameraSwitchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callEvents.onCameraSwitch();
            }
        });*/


        /*videoScalingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (scalingType == ScalingType.SCALE_ASPECT_FILL) {
                    videoScalingButton.setBackgroundResource(R.drawable.ic_action_full_screen);
                    scalingType = ScalingType.SCALE_ASPECT_FIT;
                } else {
                    videoScalingButton.setBackgroundResource(R.drawable.ic_action_return_from_full_screen);
                    scalingType = ScalingType.SCALE_ASPECT_FILL;
                }
                callEvents.onVideoScalingSwitch(scalingType);
            }
        });*/
        scalingType = ScalingType.SCALE_ASPECT_FILL;

        toggleMuteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean enabled = callEvents.onToggleMic();
                toggleMuteButton.setAlpha(enabled ? 1.0f : 0.3f);
            }
        });

        toggleSpeakerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean enabled = callEvents.onToggleSpeaker();
                if(enabled){
                    toggleSpeakerButton.setBackground(getResources().getDrawable(R.mipmap.ic_speakeroff));
                }else{
                    toggleSpeakerButton.setBackground(getResources().getDrawable(R.mipmap.ic_speaker));
                }
                //toggleSpeakerButton.setAlpha(enabled ? 1.0f : 0.3f);
            }
        });

        //admobAds();

        return controlView;

    }

    /* Admob adds function
    private void admobAds() {
        //MobileAds.initialize(controlView.getContext(),
        //        getResources().getString(R.string.admob_app_id));
        //
        MobileAds.initialize(controlView.getContext(), initializationStatus -> {

        });
        adView = controlView.findViewById(R.id.adView1);

        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);
    }
    */

    //Call timing
    Runnable r;
    private void callTiming() {
        /*
        new Handler().postDelayed(new Runnable() {
            public void run() {
                // do something...
            }
        }, 100);
        */
        r = new Runnable() {
            public void run() {
                //Log.e("Calling", String.valueOf(isCalling));
                if(isCalling)
                {
                    // progressBar.setVisibility(View.INVISIBLE);
                    // callTime.setVisibility(View.VISIBLE);
                    // Log.e("Timer",hours+":"+min+":"+sec);
                    if(min>=60)
                    {
                        hours++;
                        min=0;
                    }
                    if(sec>=60)
                    {
                        min++;
                        sec=0;
                    }
                    sec++;

                    CallFragment.callTime.setText(hours+":"+min+":"+sec);
                }
                callTiming();
            }
        };

        handler.postDelayed(r, 1000);
    }

    @Override
    public void onStart() {
        super.onStart();

        boolean captureSliderEnabled = false;
        Bundle args = getArguments();
        if (args != null) {
            String contactName = args.getString(CallActivity.EXTRA_ROOMID);

            videoCallEnabled = args.getBoolean(CallActivity.EXTRA_VIDEO_CALL, true);
            captureSliderEnabled = videoCallEnabled
                    && args.getBoolean(CallActivity.EXTRA_VIDEO_CAPTUREQUALITYSLIDER_ENABLED, false);
        }
        if (!videoCallEnabled) {
            //    cameraSwitchButton.setVisibility(View.INVISIBLE);
        }
        if (captureSliderEnabled) {
            captureFormatSlider.setOnSeekBarChangeListener(
                    new CaptureQualityController(captureFormatText, callEvents));
        } else {
            captureFormatText.setVisibility(View.GONE);
            captureFormatSlider.setVisibility(View.GONE);
        }
    }

    // TOD: Replace with onAttach(Context) once we only support API level 23+.
    @SuppressWarnings("deprecation")
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        callEvents = (OnCallEvents) activity;
    }

    public void hideProgrees()
    {
        progressBar.setVisibility(View.GONE);
        callTime.setVisibility(View.VISIBLE);
        isCalling = true;
        callTiming();
    }

    public void resetTimer() {
        handler.removeCallbacks(r);
    }

}