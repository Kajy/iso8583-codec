package codec.types.field46.field1.types

import codec.FieldCodecs.{LLVAR_N, yearMonthFormatter}
import codec.types.TokenData4601XX
import scodec.Codec

import java.time.YearMonth

// 46.1.7
case class ExpirationDate460107(date: YearMonth) extends TokenData4601XX
object ExpirationDate460107 {
  val codec: Codec[ExpirationDate460107] = LLVAR_N
    .xmap(
      YearMonth.parse(_, yearMonthFormatter),
      (t: YearMonth) => t.format(yearMonthFormatter)
    )
    .as[ExpirationDate460107]
}
