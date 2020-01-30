#!/bin/bash
if [ -z "$1" ]
  then
    echo "$0 [contract]"
    exit 1
fi
solc --abi --bin --overwrite -o . $1
fn=$(basename $1 .sol)
/bin/cat <<EOF >$fn.js
var _data$fn = "0x$(cat $fn.bin)";
var _abi$fn = $(cat $fn.abi);
var $fn = eth.contract(_abi$fn)
EOF

