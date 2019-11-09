# Q. Implement a three node point to point network with duplex links between them. Set the queue size, vary the bandwidth
#    and find the number of packets dropped.

set ns [new Simulator]

set nf [open pa1.nam w]
$ns namtrace-all $nf

set tf [open pa1.tr w]
$ns trace-all $tf

proc finish {} {
global ns nf tf
$ns flush-trace
close $nf
close $tf
exec nam pa1.nam &
exit 0
}
set n0 [$ns node]
set n1 [$ns node]
set n2 [$ns node]
set n3 [$ns node]

#$ns color 1 "red"
#$ns color 2 "blue"

$ns duplex-link $n0 $n2 0.5Mb 10ms DropTail
$ns duplex-link $n1 $n2 50Mb 5ms DropTail
$ns duplex-link $n2 $n3 10Mb 1000ms DropTail

#$ns duplex-link $n0 $n2 color "green"

$ns queue-limit $n0 $n2 10
$ns queue-limit $n1 $n2 10

set udp0 [new Agent/UDP]
$ns attach-agent $n0 $udp0

set cbr0 [new Application/Traffic/CBR]
$cbr0 set packetSize_ 500
$cbr0 set interval_ 0.005
$cbr0 attach-agent $udp0

set udp1 [new Agent/UDP]
$ns attach-agent $n1 $udp1

set cbr1 [new Application/Traffic/CBR]
$cbr1 attach-agent $udp1

set udp2 [new Agent/UDP]
$ns attach-agent $n2 $udp2

set cbr2 [new Application/Traffic/CBR]
$cbr2 attach-agent $udp2

set null0 [new Agent/Null]
$ns attach-agent $n3 $null0

$ns connect $udp0 $null0
$ns connect $udp1 $null0

$ns at 0.1 "$cbr0 start"
$ns at 0.2 "$cbr1 start"
$ns at 1.0 "finish"

$ns run
