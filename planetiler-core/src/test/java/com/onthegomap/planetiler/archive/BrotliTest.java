package com.onthegomap.planetiler.archive;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.nio.charset.StandardCharsets;
import org.junit.jupiter.api.Test;

class BrotliTest {

  @Test
  void roundTripsTileBytes() throws Exception {
    byte[] input = "a small vector tile payload with repeated payload payload payload".getBytes(StandardCharsets.UTF_8);

    assertArrayEquals(input, Brotli.decompress(Brotli.compress(input)));
  }
}
