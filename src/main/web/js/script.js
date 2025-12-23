function openMap(address) {
  let url = `https://www.google.com/maps?q=${encodeURIComponent(address)}`;
  window.open(url, "_blank");
}