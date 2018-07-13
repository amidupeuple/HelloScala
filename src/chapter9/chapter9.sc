val p = """\$[0-9]+""".r
def format(message: String, vars: String*): String = {
  p.replaceSomeIn(message, m => vars.lift(m.matched.tail.toInt))
}
format("At $1, there was $2 on $0.",
  "planet 7", "12:30 pm", "a disturbance of the force")
