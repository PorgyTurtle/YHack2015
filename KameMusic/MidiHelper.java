package KameMusic;

import javax.sound.midi.*;

public class MidiHelper{

	public static void play(int nValue) throws javax.sound.midi.MidiUnavailableException
	{
		Synthesizer synth=MidiSystem.getSynthesizer();
		long start=System.nanoTime();
		synth.open();
		long time=System.nanoTime()-start;

		MidiChannel[] chan= synth.getChannels();
		Instrument[] instr= synth.getDefaultSoundbank().getInstruments();
		boolean succ=synth.loadInstrument(instr[0]);
		chan[0].noteOn(nValue, 93);
	}
}