{
  description = "A flake for getting started with Scala.";

  inputs = {
    nixpkgs.url = "github:nixos/nixpkgs/nixpkgs-unstable";
    flake-utils.url = "github:numtide/flake-utils";
  };

  outputs =
    {
      self,
      nixpkgs,
      flake-utils,
    }:
    let
      supportedSystems = [
        "aarch64-darwin"
        "aarch64-linux"
        "x86_64-linux"
        "x86_64-darwin"
      ];
    in
    flake-utils.lib.eachSystem supportedSystems (
      system:
      let
        pkgs = import ./pkgs.nix nixpkgs system;

        makeShell =
          pkgs:
          pkgs.mkShell {
            buildInputs = with pkgs; [
              ammonite
              bloop
              coursier
              jdk
              mill
              sbt
              scala-cli
              scalafmt
            ];
          };
      in
      {
        devShells = {
          default = makeShell pkgs.default;
          java23 = makeShell pkgs.pkgs23;
          java21 = makeShell pkgs.pkgs21;
        };

        formatter = pkgs.default.alejandra;
      }
    );
}
