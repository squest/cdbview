function (doc) {
  if (doc.tCastrate === "thisone") {
    emit (doc.key, doc);
  }
}