import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { UrlBuilderService } from './url-builder.service';
import { Announcement } from "../model/model";
import { Observable, Subject } from 'rxjs';
import { NewComment } from "../model/model";

@Injectable({
  providedIn: 'root'
})
export class MongoRepoService {

  announcements!: Announcement[]

  constructor(private http: HttpClient, private urlBuilder: UrlBuilderService) { }

  public insertAnnouncement(announcement: Announcement): Observable<any> {
    let url = this.urlBuilder.setPath('api/insert-announcement').build()
    return this.http.post(url, announcement)
  }

  public editAnnouncement(announcement: Announcement): Observable<any> {
    let url = this.urlBuilder.setPath('api/edit-announcement').build()
    return this.http.put(url, announcement)
  }

  public getAnnouncementsByPage(projectAddress: string, offset: number, limit: number): Observable<any> {
    let url = this.urlBuilder.setPath('api/get-announcements-by-page').build()
    let params = new HttpParams()
      .append('projectAddress', projectAddress)
      .append('offset', offset)
      .append('limit', limit)
    return this.http.get(url, { params })
  }

  public countAnnouncements(projectAddress: string): Observable<any> {
    let url = this.urlBuilder.setPath('api/count-announcements').build()
    let params = new HttpParams().append('projectAddress', projectAddress)
    return this.http.get(url, { params })
  }

  public getCommentsByPage(projectAddress: string, offset: number, limit: number): Observable<any> {
    let url = this.urlBuilder.setPath('api/get-comments-by-page').build()
    let params = new HttpParams()
      .append('projectAddress', projectAddress)
      .append('offset', offset)
      .append('limit', limit)
    return this.http.get(url, { params })
  }

  public insertComment(comment: NewComment): Observable<any> {
    let url = this.urlBuilder.setPath('api/insert-comment').build()
    return this.http.post(url, comment)
  }

  public countComments(projectAddress: string): Observable<any> {
    let url = this.urlBuilder.setPath('api/count-comments').build()
    let params = new HttpParams().append('projectAddress', projectAddress)
    return this.http.get(url, { params })
  }

}
