package jagex2.dash3d;

import deob.ObfuscatedName;

@ObfuscatedName("ao")
public class VertexNormal {

    @ObfuscatedName("ao.r")
    public int x;

    @ObfuscatedName("ao.d")
    public int y;

    @ObfuscatedName("ao.l")
    public int z;

    @ObfuscatedName("ao.m")
    public int w;

    public VertexNormal() {
    }

    public VertexNormal(VertexNormal normal) {
        this.x = normal.x;
        this.y = normal.y;
        this.z = normal.z;
        this.w = normal.w;
    }
}
