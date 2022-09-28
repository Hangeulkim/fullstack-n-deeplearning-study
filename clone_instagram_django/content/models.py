from djongo import models

class Feed(models.Model):
    _id = models.ObjectIdField()
    content = models.TextField()
    image = models.TextField()
    profile_image = models.TextField()
    user_id = models.TextField()
    like_count = models.IntegerField()

