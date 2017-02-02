# slascala-emoji-client
Slack Emoji Client for Scala

## Usage

### Upload Emoji to your team slack
```scala
val yourTeamName = "xxxxxxxx"
val slackCookie = "yyyyyyyy"
val emojiClient = new SlascalaEmojiClient(yourTeamName, slackCookie)

emojiClient.upload("nameOfEmojiToUpload", new File("emojiImageFile")) match {
  case Left(e)  => // failed to upload emoji
  case Right(_) => // Success!
}
```

## Loadmap
- Deletion by name
- Export all regestered emoji
- Bulk upload
