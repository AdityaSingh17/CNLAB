# Part A
This folder contains all the simulation programs for Computer Netwokds Laboratory. 

## Download and extract ns-allinone-2.31.tar.xz
You will get a folder "ns-2.31" under ns-allinone-2.31 which will have all the required binaries and source files.
This folder will also contain the xgraph binary, move it to the /usr/bin/ if needed.

## Installing
### Steps to install the required software.

Install ns2
```
sudo apt install ns2
```

Install nam
```
sudo apt install nam
```
Install xgraph
```
sudo apt install xgraph
```
## Placing the files in correct folder.
```
cd ns-allinone-2.31/ns-2.31/tcl/<new-folder>/
```
Place all the .tcl files into the "new-folder" folder, run them suitable command.
### NOTE
For the wireless programs (GSM and CDMA) place the .tcl files in the wireless-scripts directory. Change directory with the following command.
```
cd ns-allinone-2.31/ns-2.31/tcl/ex/wireless-scripts/
```
## Running the simulation
To run a .tcl file, (this will create a .tr (trace) file).
```
ns <filename>.tcl
```

To run the .awk file
```
awk -f <filename>.awk
```
### NOTE
The awk command expects an input .tr file, run it with the following command.
```
awk -f <filename>.awk <filename>.tr
```

