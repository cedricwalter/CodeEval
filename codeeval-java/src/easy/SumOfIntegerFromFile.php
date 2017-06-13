<?php
$fh = fopen($argv[1], "r");
while (!feof($fh)) {
  $sum += fgets($fh);
}
echo $sum;
fclose($fh);
?>