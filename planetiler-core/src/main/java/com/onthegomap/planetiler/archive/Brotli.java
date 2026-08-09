package com.onthegomap.planetiler.archive;

import com.aayushatharva.brotli4j.Brotli4jLoader;
import com.aayushatharva.brotli4j.decoder.Decoder;
import com.aayushatharva.brotli4j.encoder.Encoder;
import java.io.IOException;

/** Brotli tile compression with the quality used by Fotoshi's current PMTiles postprocessor. */
public final class Brotli {

  private static final int QUALITY = 6;

  private Brotli() {}

  public static byte[] compress(byte[] input) throws IOException {
    Brotli4jLoader.ensureAvailability();
    return Encoder.compress(input, new Encoder.Parameters().setQuality(QUALITY));
  }

  public static byte[] decompress(byte[] input) throws IOException {
    Brotli4jLoader.ensureAvailability();
    return Decoder.decompress(input).getDecompressedData();
  }
}
