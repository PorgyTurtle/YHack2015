package KameMusic;

import javax.sound.midi.*;

public class MidiHelper{

	public static Synthesizer synth;

	public static void start() throws javax.sound.midi.MidiUnavailableException
	{
		 synth=MidiSystem.getSynthesizer();
	}

	public static void play(int nValue) throws javax.sound.midi.MidiUnavailableException
	{
		synth.open();

		MidiChannel[] chan= synth.getChannels();
		Instrument[] instr= synth.getDefaultSoundbank().getInstruments();
		synth.loadInstrument(instr[1]);
		chan[0].noteOn(nValue, 93);
	}

	public static void stop(int nValue) throws javax.sound.midi.MidiUnavailableException
	{
		synth.open();

		MidiChannel[] chan= synth.getChannels();
		Instrument[] instr= synth.getDefaultSoundbank().getInstruments();
		synth.loadInstrument(instr[1]);
		chan[0].noteOff(nValue, 93);
	}
}