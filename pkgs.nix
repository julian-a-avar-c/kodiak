nixpkgs: system:
let
  makeOverlays =
    java:
    let
      ammoniteOverlay = final: prev: {
        ammonite = prev.ammonite.override {
          jre = final.${java};
        };
      };

      bloopOverlay = final: prev: {
        bloop = prev.bloop.override {
          jre = final.jre;
        };
      };

      millOverlay = _: prev: {
        mill = prev.mill.override {
          # hardcoded because mill requires 11 or above
          # jre = pkgsForGraal.graalvm-ce;
        };
      };

      javaOverlay = final: _: {
        jdk = final.${java};
        jre = final.${java};
      };

      scalaCliOverlay = _: prev: {
        scala-cli = prev.scala-cli.override {
        };
      };
    in
    [
      javaOverlay
      bloopOverlay
      scalaCliOverlay
      ammoniteOverlay
      millOverlay
    ];

  makePackages =
    java: graal:
    let
      overlays = makeOverlays java graal;
    in
    import nixpkgs {
      inherit system overlays;
    };

  default = pkgs23;
  pkgs21 = makePackages "temurin-bin-21" false;
  pkgs23 = makePackages "temurin-bin-23" false;
in
{
  inherit
    default
    pkgs21
    pkgs23
    ;
}
