package io.github.todokr

import java.io.File
import java.nio.charset.StandardCharsets
import javax.activation.FileTypeMap

import scala.util.control.Exception._

import org.jsoup.Jsoup
import skinny.http._

class SlascalaEmojiClient(teamName: String, slackCookie: String) {

  private val url = s"https://$teamName.slack.com/customize/emoji"

  def upload(emojiName: String, emojiImage: File): Either[Throwable, Unit] = {

    allCatch either {
      val startPageResponse = HTTP.get(Request(url).header("Cookie", slackCookie))
      val doc = Jsoup.parse(startPageResponse.textBody)
      val crumb = doc.body().getElementsByAttributeValue("name", "crumb").attr("value")
      val mime = FileTypeMap.getDefaultFileTypeMap.getContentType(emojiImage)
      val multipart = Seq(
        FormData("add", TextInput("1", StandardCharsets.UTF_8.name)),
        FormData("crumb", TextInput(crumb, StandardCharsets.UTF_8.name)),
        FormData("name", TextInput(emojiName, StandardCharsets.UTF_8.name)),
        FormData("mode", TextInput("data", StandardCharsets.UTF_8.name)),
        FormData("img", FileInput(emojiImage, mime))
      )

      val uploadRequest = Request(url).header("Cookie", slackCookie).multipartFormData(multipart).followRedirects(false)
      val uploadResponse = HTTP.post(uploadRequest)

      val errorMessage = Jsoup.parse(uploadResponse.textBody).select(".alert").not("[style]").text().trim
      if (errorMessage.nonEmpty) throw new Exception(errorMessage)
    }
  }

}
