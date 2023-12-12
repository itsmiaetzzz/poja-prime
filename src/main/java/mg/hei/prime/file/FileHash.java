package mg.hei.prime.file;

import mg.hei.prime.PojaGenerated;

@PojaGenerated
public record FileHash(FileHashAlgorithm algorithm, String value) {}
