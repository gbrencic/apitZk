#version 120

uniform sampler2D u_texture;

varying vec4 vColor;
varying vec2 vTexCoord;
varying float vSubs;

void main() {
   vec4 color = texture2D(u_texture, vTexCoord);
   color.rgb = color.rgb - vSubs * 0.5;
   color.rgb = color.rgb - color.rgb * (vSubs * 0.5);
       gl_FragColor = color;
}