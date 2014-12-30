function (doc) {
  if (doc.{{type}} === "{{variables}}") {
    emit (doc.{{thekey}}, doc);
  }
}